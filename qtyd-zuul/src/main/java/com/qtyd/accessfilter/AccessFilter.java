package com.qtyd.accessfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.qtyd.utils.DesUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/18
 * @Description: 访问拦截
 **/
@Component
public class AccessFilter extends ZuulFilter{

    private static final String DEFAULT_ACCESSID="628c634cdf326b1f5ef4a9554c48f349";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//        String accessId = request.getHeader("accessId");
//
//        System.out.println("accessId:"+accessId);
        //校验accessId
//        if(accessId==null||accessId.isEmpty()){
//            System.out.println("accessId为空禁止访问......");
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(401);
//            return null;
//        }
        //校验用户是否登录
//        if(!accessId.equals(DesUtils.encrypt("1274256"+DEFAULT_ACCESSID))){
//            System.out.println("已登录accessId校验不通过");
//            return null;
//        }

        //未登录校验默认accessId
//        if(!accessId.equals(DEFAULT_ACCESSID)){
//            System.out.println("未登录accessId校验不通过");
//            return null;
//        }
        //添加认证信息
//        requestContext.addZuulRequestHeader("accessId", DesUtils.encrypt("5eb26bf9a8acd16e6dad1a222e78a1cc5179039dc8225e59c3341d9ed1824c273abcc960215ed4e6"));
        return null;


//        try {
//            RequestContext context = getCurrentContext();
//            InputStream in = (InputStream) context.get("requestEntity");
//            if (in == null) {
//                in = context.getRequest().getInputStream();
//            }
//            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
//            body = "动态增加一段内容到body中: " + body;
//            byte[] bytes = body.getBytes("UTF-8");
//            context.setRequest(new HttpServletRequestWrapper(getCurrentContext().getRequest()) {
//                @Override
//                public ServletInputStream getInputStream() throws IOException {
//                    return new ServletInputStreamWrapper(bytes);
//                }
//
//                @Override
//                public int getContentLength() {
//                    return bytes.length;
//                }
//
//                @Override
//                public long getContentLengthLong() {
//                    return bytes.length;
//                }
//            });
//        } catch (IOException e) {
//            rethrowRuntimeException(e);
//        }
//        return null;

//        RequestContext ctx= RequestContext.getCurrentContext();
//        HttpServletRequest req=ctx.getRequest();
//        String ipAddr=this.getIpAddr(req);
//        logger.info("请求IP地址为：[{}]",ipAddr);
//        //配置本地IP白名单，生产环境可放入数据库或者redis中
//        List<String> ips=new ArrayList<String>();
//        ips.add("172.0.0.1");
//
//        if(!ips.contains(ipAddr)){
//            logger.info("IP地址校验不通过！！！");
//            ctx.setResponseStatusCode(401);
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseBody("IpAddr is forbidden!");
//        }
//        logger.info("IP校验通过。");
//        return null;
    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    public  String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static String getBase64Credentials(String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    public static void main(String[] args) {
        System.out.println("Basic " + getBase64Credentials("test", "123456"));
    }

}
