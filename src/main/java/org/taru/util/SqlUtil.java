package org.taru.util;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
/**
 * �����������ݿ� 
 * @author SZT
 *
 */

/**
 *  * ��η�װ ���� 
 *   ��Щ�Ǳ�� ��     SQL�Ǳ仯   �����Ǳ仯     ��ѯ�� DML�ǲ�ͬ��   
 *   ��Щ�ǲ���� �� �����ǲ��仯  �����ǲ����  �ر� Ҳ�ǲ����
 */
public class SqlUtil {
	
	private  static  final  String  DRIVER="driver";
	private  static  final  String  URL ="url";
	private  static  final  String  USERNAME="username";
	private  static  final  String  PASSWORD="password";
	
	static  Properties proper =new Properties();
	
	//��̬��Ա����  ��jvm ��ֻ��һ�ݣ��������ÿһ����һ���أ�  ��ô��Ҫ�õ����������������
	//private static Connection conn=null;
	/*
	 * local ���˵�ǰ���̣߳���������һ��������Map�ļ��ϣ�����ֻ��һ��Value��Key���ǵ�ǰ�̣߳���ͬһ���̵߳��У�ȡ����Value����ͬ�ġ�
	 * ��ֵ:set()����     ȡֵ:get()������
	 * 
	 * ThreadLocal<Connection>  ���ǰ��˵�ǰ���̡߳�<Connection>�������ֵ��key�ǵ�ǰ���߳�
	 * 
	 *  ͬһ���߳� ֻ��һ������  ��һ���߳�֮�� ����һ�����ӡ�
	 *     �򸱱�ʱ������ͬһ���������ţ����ǽ�����ͬһ���̣߳�Ҳ����Ϊ��Ҷ���ֱ���һ��һ��һ���ĵ�BOSS��
	 *     ������ǻῴ�������������BOSS��һ��һ���ģ����Ǳ��˴����ˣ�ȴ����Ӱ�쵽�ҷ����ڹ�����BOSS.
	 */
	//���ر���  ����  �̱߳���   �� 
	static  ThreadLocal<Connection>   container=new  ThreadLocal<Connection>();

	//����
	static{		
		try {
			//ͨ���������       ���������·���µ����������ļ�  �� "jdbc.properties"jdbcǰ˭Ҳ����  ���Ƿ���  ��Ŀ¼src�� 
			proper.load(SqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			System.out.println("��ʼ�����������ļ��ɹ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//1����������
	static {
		try {
			Class.forName(proper.getProperty(DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2����ȡ����
	public static Connection   getConnection(){
		Connection  conn =container.get();//ȡ����  container
		try {
			if(conn==null  || conn.isClosed()){
				conn =	DriverManager.getConnection(proper.getProperty(URL),
						proper.getProperty(USERNAME),proper.getProperty(PASSWORD));
				container.set(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  conn;
	}
	//����  ��ѯ��ִ��DQL��� ResultSet �ر�֮�� �����޷�ȡ������//... �ɱ������ʹ��ʱֻ��ֱ�Ӵ��ͺ�  List �����  ��ArrayListֻ����ArrayList
	//HasMap�������ݡ�  map�����
	public  static ArrayList<HashMap<String,Object>>    executeQuery(String sql,Object ... params){
		
		//ArrayList<HashMap<String,Object>>  list=new  ArrayList<HashMap<String,Object>>();
		ArrayList<HashMap<String,Object>>  list=null;
		
		Connection conn =	getConnection();
		PreparedStatement pst=null;
		ResultSet  rs=null;//�Ƚ����⣬�����Ͳ��ܹر����ӵģ�ֱ�����������     �����������ֵҲ������(ԭ����)
		try {
			pst =conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			rs =pst.executeQuery();

			//����ResultSet ������HashMap ��ArrayList�����  һ������HashMap ����������ArrayList
			//��ʽһ
			//int count = rs.getMetaData().getColumnCount(); //��ȡ�е�����
			//��ʽ��
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			
			System.out.println(count);			
			list=new  ArrayList<HashMap<String,Object>>();			
			while(rs.next()){
				HashMap<String ,Object>  row =new  HashMap<String ,Object> ();//����  �����ַ������Ծ��� String�ͺã�ֵ�Ǹ�������������Object
				for(int i=0;i<count;i++){
					/*//��ʽһ
					String key =rs.getMetaData().getColumnLabel(i+1);//��ý������ ԭ���� ��������getColumnLabel(i+1)��õڼ��е����֣�����3���ǵõ���4���е�����
					Object  value =rs.getObject(key);
					row.put(key, value);*/
					//��ʽ��
					row.put(rsmd.getColumnLabel(i+1),rs.getObject(i+1));					
					//���forѭ��   ʵ�ֱ���������   ���ǲ������forѭ��  Ҳ�ǿ����������е��к���			
					/*for(int i1=0;i<count;i++){
						row.put(rsmd.getColumnLabel(i+1),rs.getObject(i+1));//�м�����  �ͼӼ���
					}*/
					
				}
				list.add(row);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ִ�в�ѯ����");//������  ץ������ �׳�ȥ������������Ҳ����ץ��
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  list;
		
		
	}
	
	
	//ִ��DML  �������
	public  static int    executeUpdate(String sql,Object... params){
		Connection conn =	getConnection();
		int row=0;
		PreparedStatement pst=null;

		try {
			pst  =	conn.prepareStatement(sql);
			System.out.println(pst);// 此处 验证将sql语句传入后 返回的pst 里面到底是什么
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			System.out.println(pst); //验证 经过处理后的pst  里面是什么
			row =  pst.executeUpdate();
			//int result = stat.executeUpdate(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
					pst=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  row;
		
		
	}
	
	//�ر���Դ  �ر����ݿ�����
	public  static void   close(){
		if(container.get()!=null){//Ϊ�����ָ��  �� if �ж�
			try {
				container.get().close();
				container.remove();
				//container.get()=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
		
}

