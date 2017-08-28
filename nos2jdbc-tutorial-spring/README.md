# nos2jdbcのspring用チュートリアルです

springのスタンドアローンアプリです。   
Mavenプロジェクトです。   

## 実行方法
### コンパイル
最初にこれをするのは、src/main/resources/nos2jdbc-datasource.propertiesを、
nos2jdb-genから見えるようにするため。  
`mvn compile`
### DDL作成
nos2jdbc-genをMavenから実行します。   
`mvn antrun:run -Dant.target=gen-ddl`   
### migrate
`mvn antrun:run -Dant.target=migrate`   
### 実行
`mvn compile exec:java`   
ログにまぎれて、コンソールにDBの内容が出力されます。   


