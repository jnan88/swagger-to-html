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
		String dir = System.getProperty("user.dir");
		System.out.println("运行目录为 :" + dir);
		SwaggerToHtmlUtil.createAdocFile(args[0], dir);
		SwaggerToHtmlUtil.createHtmlFromAdoc(dir);
	}
}
