# nos2jdbcのspring boot用チュートリアルです

spring bootのスタンドアローンアプリです。   
Mavenプロジェクトです。   

## 実行方法
#### java17以降の場合
antへのオプションの渡し方がわからないので、   
`export JAVA_TOOL_OPTIONS='--add-opens=java.base/java.lang=ALL-UNNAMED'`   
として下さい。
### コンパイル
`mvn compile -Pcompile-least`   
これは、リソースのコピーとEntityのコンパイルだけをして、genを使えるようにします。
### DDL作成
nos2jdbc-genをMavenから実行します。   
`mvn antrun:run -Dant.target=gen-ddl`   
### migrate
`mvn antrun:run -Dant.target=migrate`   
### 実行
`mvn compile exec:java`   
ログにまぎれて、コンソールにDBの内容が出力されます。   


