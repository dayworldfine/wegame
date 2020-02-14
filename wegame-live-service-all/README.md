#杭州壹个家科技研发中心项目
---

### 1. 项目结构 

-  公共模块（vertx-ext）
-  Demo模块（vs-demo）

### 2. 技术选型

-  核心框架：[Vert.x](https://vertx.io/)、[Spring-boot](https://spring.io/projects/spring-boot)
-  持久层框架：[BeetlSql](http://ibeetl.com/guide/#beetlsql)
-  数据库连接池：[HikariCP](http://brettwooldridge.github.io/HikariCP/)
-  JAVA常用工具：[Hutool](https://hutool.cn/docs/#/)
-  JAVA模版：[Beetl](http://ibeetl.com/guide/#beetl)
-  消息框架：[Event Bus](https://vertx.io/docs/vertx-core/java/#event_bus)
-  缓存框架：Redis
-  注册中心：Zookeeper
-  API服务：[Vert.x-Web](https://vertx.io/docs/vertx-web/java/)
-  服务代理：[Vert.x-Service-Proxy](https://vertx.io/docs/vertx-service-proxy/java/)
-  分布式日志：SLF4J

### 3. 注意事项

-  所有数据库ID为long，且非自增，使用SeqUtil.next()填充。
-  严禁在代码循环中进行数据库增删改查操作；如遇到此查询场景，先查询出数据库大集合，再使用Java代码筛选，增删改操作则组成批量进行。
-  Service层方法是异步执行，必须对异常进行处理，如是服务器异常统一返回信息“当前接口正在维修中……”。
-  前后端交互时，入参和回参里面的具体字段属性全部为字符串，所有回参必须为前端需要的格式。
-  Get、DELETE请求参数以/:id/:age形式，理解为参数必传，并禁止中文参数和重要信息参数。
-  Post请求统一使用body传值，禁止以?id=xx&age=xx形式。
-  前端需要的提示语均为后端返回。
-  Web层只处理参数校验和实体装载，统一在reVo层实体进行，参数传入Service层执行具体逻辑。
-  Web层返回前端统一使用ar -> HttpUtil.create().fireJsonData(ctx,ar)或者ar -> HttpUtil.create().fireJsonMsg(ctx,ar)
-  在Web层返回正确信息使用HttpUtil.fireJsonSuccess(ctx,"xxx操作成功")，返回错误信息使用HttpUtil.fireJsonError(ctx,"xxx参数有误")。

### 4. 项目结构
-  entity：数据库多表混合实体
-  mapper：对应混合实体的mapper方法
-  service：具体业务逻辑
-  web：路由
-  filter：路由前置拦截
-  vo：路由入参实体
-  dto：Service回参实体

### 5. 命名规范

-  层级和包命名全部小写，文件以简单英文全拼驼峰+当前层命名，如当前层级为web，UserTokenWeb
-  Web层方法需要添加并维护方法注释，[xxx]表示参数可选，如下：
````
    /**
     * @api {POST} /search 条件分页查询客户端系统列表
     * @apiGroup 客户端系统管理
     * @apiVersion 0.0.1
     * @apiDescription 条件查询客户端系统列表
     * @apiParam {String} content 系统名称
     * @apiParam {String} [recommend] 邀请码
     * @apiParamExample {json} 请求样例：
     *                {"account":"sodlinken","recommend":"11223344"}
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {JSON} data {} 
     * @apiSuccessExample {json} 返回样例:
     *                {"msg":"0","data":{}}
     * @apiError (400) {String} msg 信息
     * @apiError (400) {JSON} data {} 
     * @apiErrorExample {json} 返回样例:
     *                {"msg":"0","data":{}}
     */

````
