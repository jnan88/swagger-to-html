# swagger-to-html
swagger可视化工具，用于指定的swagger url 生成可视化的单页面html

## 依赖环境
jdk8

## 使用方法
```
java -jar swagger-to-html.jar "此处是你swaggerAPI的json内容访问地址"
```

例如：java -jar swagger-to-html.jar "http://localhost:8080/v2/api-docs"

生成完毕后将在运行目录下创建两个文件：apidoc.adoc和apidoc.html
