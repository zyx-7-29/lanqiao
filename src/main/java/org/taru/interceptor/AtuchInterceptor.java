package org.taru.interceptor;

/**
 * 判断用户是否登陆
 */
//public class AtuchInterceptor implements HandlerInterceptor {
//
//    private Map<String, PrivilegeAM> map=new HashMap<>();
//
//    /**
//     * (先前预备)请求发送到 Controller之前调用
//     * @param request
//     * @param response
//     * @param o
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//
//        map.put("",new PrivilegeAM("添加用户"));
//        map.put("",new PrivilegeAM("添加用户"));
//        map.put("",new PrivilegeAM("添加用户"));
//        map.put("",new PrivilegeAM("添加用户"));
//
//        String requestURI=request.getRequestURI();
//
//        if (map.get(requestURI) == null){
//            return  true;
//        }
//
//        if(requestURI.indexOf("")<=0){
//            //说明处在编辑的页面
//            HttpSession session =request.getSession();
//            Object object=session.getAttribute("UserKey");
//            if(object != null){
//                //登陆成功的用户 放行
//                return true;
//            }else{
//                //没有登陆的   转向登陆页面
//                request.getRequestDispatcher("").forward(request,response);
//                return false;
//            }
//
//
//        }else{
//            return  false;
//        }
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    /**
//     * 请求发送到Controller之后调用
//     * 回来的时候  刚刚执行完毕Controller  还没有视图渲染。例如：逻辑视图 “main”
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @param o
//     * @param modelAndView
//     * @throws Exception
//     */
//
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    /**
//     * 完成请求的处理的回调方法
//     * 整个请求结束之后执行 试图已经渲染完毕 例如：“mian"已经 变成/WEB-INF/main.jsp
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @param o
//     * @param e
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
