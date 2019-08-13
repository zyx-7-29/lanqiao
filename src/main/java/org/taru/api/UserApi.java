package org.taru.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.taru.Entity.User;
import org.taru.service.SearchAllUserService;
import org.taru.vo.JsonResult;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
public class UserApi {

    /**
     * 通过Value注解获得属性配置文件的信息。
     * ${}  取 properties中的信息
     */
    @Value("${upload.absolutePath}")
    private String uploadAbsolutePath; //动态的路径

    /**
     * 通过Value注解获得XML文件中的的信息。
     * #{}  取 XML文件中的的信息。
     */
    @Value("#{testBean.testName}")
    private String uploadAbsolutePath2; //动态的路径



    /**
     * 上传图片
     * MultipartFile 代表了一个上传的 二进制文件
     * @param user
     * @param multipartFile
     * @return
     */
    @RequestMapping("/api/user/upload")
    public JsonResult upload (User user, @RequestParam("image-header")MultipartFile multipartFile){
        JsonResult result=null;
        if(!multipartFile.isEmpty()){
            try{
                /**
                 * 给图片 重新命名
                 */
                //方式一：
                // 取得原文件名
                //String oldName = multipartFile.getOriginalFilename();
                //得到文件新名字
                //String newName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + oldName;
                //System.out.println(newName);//测试

                //方式二：
                // 取得原文件名
                String oldName = multipartFile.getOriginalFilename();
                // 取得文件后缀
                String fileExt = oldName.substring(oldName.lastIndexOf(".") + 1);
                // 按时间戳生成图片文件名不包括后缀
                String name = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                //得到新文件的名字
                String newName = name + "."+ fileExt;
                System.out.println(name);//测试

                //上传图片到指定路径：uploadAbsolutePath2 就是了路径
                multipartFile.transferTo(new File(uploadAbsolutePath2+"\\"+newName));

                result=new JsonResult("200","上传头像成功","data");
            }catch(Exception e){
                e.printStackTrace();
                     result= new JsonResult("500","上传头像失败","");
            }
        }else{
            result =new JsonResult("404","没有数据","");
        }
        return result;
    }


    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/api/user/queryall")
    public JsonResult QueryAll(){
        JsonResult result=null;
        SearchAllUserService searchAllUserService=null;
        try {
            searchAllUserService =new SearchAllUserService();
            List<User> list=searchAllUserService.SearchUserDetail();
            if(list.size()>0){
                result= new JsonResult("200","查询所有用户成功","list");
            }else {
                result =new JsonResult("500","查询所有用户失败","list");
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new JsonResult("404","没有数据","");
        }
        return null;
    }
}
