/**
 * 
 */
package xyz.nesting.swaggertohtml.util;

import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

/**
 * 描述：
 * 
 * <pre>
 * TODO(添加描述)
 * </pre>
 * 
 * @author [天明]jiannan@intbee.com
 * @version: 0.0.1 2019年1月27日-下午2:51:58
 *
 */
public class SwaggerToHtmlUtil {
	static String fileNameStart = "/apidoc";

	/**
	 * 文件名为：saveDir.html
	 * 
	 * @param saveDir
	 */
	public static void createHtmlFromAdoc(String saveDir) {
		saveDir = saveDir + fileNameStart;
		System.out.println("#####################################");
		System.out.println("create html save to " + saveDir + ".html");
		Asciidoctor asciidoctor = Asciidoctor.Factory.create();
		Map<String, Object> attr = new HashMap<String, Object>();
		attr.put("toc", "left");
		attr.put("toclevels", 3);
		attr.put("sectnums", true);
		OptionsBuilder optionsBuilder = OptionsBuilder.options().safe(SafeMode.UNSAFE).inPlace(true).docType("book")
				.headerFooter(true).backend("html").attributes(attr);
		// String[] result = asciidoctor.convertDirectory(new
		// AsciiDocDirectoryWalker("target/asciidoc"), optionsBuilder);
		asciidoctor.convertFile(Paths.get(saveDir + ".adoc").toFile(), optionsBuilder);
	}

	/**
	 * 文件名为：saveDir.adoc
	 * 
	 * @param remoteSwaggerFile
	 * @param saveDir
	 * @throws Exception
	 */
	public static void createAdocFile(String url, String saveDir) throws Exception {
		saveDir = saveDir + fileNameStart;
		System.out.println("#####################################");
		System.out.println("create adoc from " + url + " ,save to " + saveDir + ".adoc");
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS).withGeneratedExamples().withoutInlineSchema()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC).build();
		Swagger2MarkupConverter.from(new URL(url)).withConfig(config).build().toFile(Paths.get(saveDir));
	}
}
