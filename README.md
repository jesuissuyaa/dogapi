## about this project

web API created based on the below Qiita article:
https://qiita.com/yukihirai0505/items/a4a8be77f39d4a357093

uses:
- Scala
- Slick
- Akka HTTP

## how to run this project 

1. go to project directory
2. `sbt run`
3. start mysql server with `mysql.server start`

don't forget to close mysql server when done :)
`mysql.server stop`

see below for mysql commands:
https://qiita.com/fuwamaki/items/194c2a82bd6865f26045#mysql%E8%87%AA%E4%BD%93%E3%81%AE%E8%B5%B7%E5%8B%95%E5%81%9C%E6%AD%A2

## notes

- scala version needs to be 2.11.8; other versions might be incompatible for libraries such as akka
- `O.PrimaryKey` `O.AutoInc`: both are capital letters of the alphabe O, not the number zero

