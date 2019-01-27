/**
 * 
 */
package xyz.nesting.swaggertohtml;

import xyz.nesting.swaggertohtml.util.SwaggerToHtmlUtil;

/**
 * 描述：
 * 
 * <pre>
 * TODO(添加描述)
 * </pre>
 * 
 * @author [天明]jiannan@intbee.com
 * @version: 0.0.1 2019年1月27日-下午2:55:39
 *
 */
public class Application {

	public static void main(String[] args) throws Exception {
		if (null == args || args.length < 1) {
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------");
			System.out.println("使用方式：java -jar swagger-to-html.jar [此处是你swaggerAPI的json内容访问地址]");
			System.out.println("例如：java -jar swagger-to-html.jar \"http://localhost:8080/v2/api-docs\"");
			System.out.println("运行结果在当前目录，文件名为apidoc.html");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------");
			return;
		}
		String dir = System.getProperty("user.dir");
		System.out.println("运行目录为 :" + dir);
		SwaggerToHtmlUtil.createAdocFile(args[0], dir);
		SwaggerToHtmlUtil.createHtmlFromAdoc(dir);
	}
}
