# nos2jdbcのwildfly用チュートリアルです

wildflyのjax-rsアプリです。   
Mavenプロジェクトです。   
## 実行までの過程
### DataSource作成
src/main/java/nos2jdbc/tutorial/wildfly/config/Resources.javaのDataSourceのjndi名と合わせて,   
wildfly上にDataSourceを作って下さい。
### nos2jdbc-datasource.propertiesの編集
二度手間ですが、nos2jdbc-genはwildfly上のDataSourceを使えないため、   
DataSourceの設定と合わせて、   
forgen/resources/nos2jdbc-datasource.propertiesを編集してください。
### pom.xmlの編集
propertiesのwf.とjdbc.で始まるpropertyを編集してください。
### コンパイル
`mvn compile -Pcompile-least`   
これは、genに必要なリソースのコピーとEntityだけのコンパイルです。
### DDL作成
nos2jdbc-genをMavenから実行します。   
`mvn antrun:run -Dant.target=gen-ddl`   
### migrate
`mvn antrun:run -Dant.target=migrate`
### deploy
`mvn wildfly:deploy`
### 実行
wildflyの設定に合わせてブラウザで、   
`http://localhost:8080/nos2jdbc-tutorial-wildfly/rest/club/list/`   
とアクセスするとDBの内容のjsonが返されます。  
## Testもできます。
src/test/resources/arquillian.xmlのwildflyのインストールフォルダを編集して、   
`mvn test -Parq-wildfly-managed`   
と、してください。
