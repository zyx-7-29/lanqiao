package org.taru.test;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Properties;

public class DaYin {

    public DaYin(){

    }
    @Resource(name="a3")
    private  String name;

    public void setPage(Page page) {
        this.page = page;
    }

    @Resource(name="a4")
    Page page;

    Link link;

    private  List<String> list;
    private  List<Link> links;
    private Properties properties;

    public void setName(String name) {
        this.name = name;
    }
//有构造方法  可以使用构造方法注入
    public DaYin(Page page,Link ling){
        this.page=page;
        this.link=ling;
    }
    public  void innie (){
        page=new A3();
        page.Write();
        link=new Blue();
        link.Color();
    }

    public  void out(){
        System.out.println("打印机正在运行");
        page.Write();
        link.Color();
    }

}

    class Page{
        public void Write(){
        System.out.println("正在书写");
    }

    }
    class A3 extends Page{
        public void Write(){
             System.out.println("A3纸正在书写");
        }
    }

    class A4 extends Page{
        public void Write(){
        System.out.println("A4纸正在书写");
    }
    }

@Component
    class Link{
        public  void  Color(){
        System.out.println("墨盒再上色");
    }
    }
@Component
class Blue extends  Link{
    public  void  Color(){
        System.out.println("蓝色墨盒再上色");
    }
}
@Component
class Break extends Link {
    public  void  Color(){
        System.out.println("黑色墨盒再上色");
    }
}

