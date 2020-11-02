<h1 style="text-align: center">可期教学管理系统 - 后端</h1>
<div style="text-align: center">

[![AUR](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://github.com/Charles7c/k7tm-backend/master/LICENSE)
[![star](https://github.com/Charles7c/k7tm-backend/badge/star.svg?theme=white)](https://github.com/Charles7c/k7tm-backend)
[![GitHub stars](https://img.shields.io/github/stars/Charles7c/k7tm-backend.svg?style=social&label=Stars)](https://github.com/Charles7c/k7tm-backend)
[![GitHub forks](https://img.shields.io/github/forks/Charles7c/k7tm-backend.svg?style=social&label=Fork)](https://github.com/Charles7c/k7tm-backend)

</div>

#### 项目简介
一个基于 Spring Boot 2.1.0 、 Spring Boot Jpa&MyBatis Plus、 JWT、Spring Security、Redis、Vue的前后端分离的教学管理后台系统

**开发文档：**  暂无

**体验地址：**  暂无

**账号密码：** 暂无

#### 项目源码

|  开源平台  |   后端源码  |   前端源码  |
|---  |--- | --- |
|  github   |  https://github.com/Charles7c/k7tm-backend   |  https://github.com/Charles7c/k7tm-pc   |

#### 主要特性
- 使用最新技术栈，社区资源丰富。
- 高效率开发，代码生成器可一键生成前后端代码
- 支持数据字典，可方便地对一些状态进行管理
- 支持接口限流，避免恶意请求导致服务层压力过大
- 支持接口级别的功能权限与数据权限，可自定义操作
- 自定义权限注解与匿名接口注解，可快速对接口拦截与放行
- 对一些常用地前端组件封装：表格数据请求、数据字典等
- 前后端统一异常拦截处理，统一输出异常，避免繁琐的判断
- 支持在线用户管理与服务器性能监控，支持限制单用户登录
- 支持运维管理，可方便地对远程服务器的应用进行部署与管理

####  教学管理功能
- 班级管理：提供班级信息的配置
- 学员管理：提供学员信息的配置
- 教学配置：提供教学阶段、教学课程等基础信息的配置
- 宿舍管理：

####  系统功能
- 用户管理：提供用户的相关配置，新增用户后，默认密码为123456
- 角色管理：对权限与菜单进行分配，可根据部门设置角色的数据权限
- 菜单管理：已实现菜单动态路由，后端可配置化，支持多级菜单
- 部门管理：可配置系统组织架构，树形表格展示
- 岗位管理：配置各个部门的职位
- 字典管理：可维护常用一些固定的数据，如：状态，性别等
- 系统日志：记录用户操作日志与异常日志，方便开发人员定位拍错
- SQL监控：采用druid 监控数据库访问性能，默认用户名admin，密码123456
- 定时任务：整合Quartz做定时任务，加入任务日志，任务运行情况一目了然
- 代码生成：高灵活度生成前后端代码，减少大量重复的工作任务
- 邮件工具：配合富文本，发送html格式的邮件
- 七牛云存储：可同步七牛云存储的数据到系统，无需登录七牛云直接操作云数据
- 支付宝支付：整合了支付宝支付并且提供了测试账号，可自行测试
- 服务监控：监控服务器的负载情况
- 运维管理：一键部署你的应用
- 区域管理：提供全国区域信息的配置

#### 项目结构
项目采用按功能分模块的开发方式，结构如下
- `k7tm-biz` 教学管理系统的核心业务模块

- `k7tm-admin` 系统启动入口，解决循环依赖

- `eladmin-common` 为系统的公共模块，各种工具类，公共配置存在该模块

- `eladmin-system` 为系统核心模块也是项目入口模块，也是最终需要打包部署的模块

- `eladmin-logging` 为系统的日志模块，其他模块如果需要记录日志需要引入该模块

- `eladmin-tools` 为第三方工具模块，包含：图床、邮件、云存储、本地存储、支付宝

- `eladmin-generator` 为系统的代码生成模块，代码生成的模板在 system 模块中

#### 详细结构

```
- k7tm-biz 教学系统主要业务模块
- k7tm-admin （系统启动入口，解决循环依赖）
- eladmin-common 公共模块
    - annotation 为系统自定义注解
    - aspect 自定义注解的切面
    - base 提供了Entity、DTO基类和mapstruct的通用mapper
    - config 自定义权限实现、redis配置、swagger配置、Rsa配置等
    - exception 项目统一异常的处理
    - utils 系统通用工具类
- eladmin-system 系统核心模块
	- config 配置跨域与静态资源，与数据权限
	    - thread 线程池相关
	- modules 系统相关模块(登录授权、系统监控、定时任务、运维管理等)
- eladmin-logging 系统日志模块
- eladmin-tools 系统第三方工具模块
- eladmin-generator 系统代码生成模块
```
    
#### 系统预览
下方预览图暂时为本项目采用的基础框架EL-ADMIN系统截图
<table>
    <tr>
        <td><img src="https://img.el-admin.xin/20200605172248.png"/></td>
        <td><img src="https://img.el-admin.xin/20200605172339.png"/></td>
    </tr>
    <tr>
        <td><img src="https://img.el-admin.xin/20200605172432.png"/></td>
        <td><img src="https://img.el-admin.xin/20200605172455.png"/></td>
    </tr>
    <tr>
        <td><img src="https://img.el-admin.xin/20200605172536.png"/></td>
        <td><img src="https://img.el-admin.xin/20200605172558.png"/></td>
    </tr>
    <tr>
        <td><img src="https://img.el-admin.xin/20200605172645.png"/></td>
        <td><img src="https://img.el-admin.xin/20200605172715.png"/></td>
    </tr>
</table>

#### 特别鸣谢

- 感谢 PanJiaChen 的前端模板项目：[vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)

- 感谢 Elunez 的后台管理系统框架：[EL-ADMIN](https://github.com/elunez/eladmin)

#### 代码及Git提交规范

- 后端代码编写建议参考[《阿里巴巴Java开发手册（嵩山版）》](https://github.com/alibaba/p3c/blob/master/Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C%EF%BC%88%E5%B5%A9%E5%B1%B1%E7%89%88%EF%BC%89.pdf)
    - 配合Intellij IDEA的Alibaba Java Code Guidelines插件使用，体验更佳
    - 插件具体使用方法可参考：[《阿里巴巴Java开发手册插件》](https://blog.csdn.net/wjn19921104/article/details/80171913)
- Git提交模板建议参考[AngularJS仓库](https://github.com/angular/angular.js)的提交规范
    - 配合Intellij IDEA或WebStorm的Git Commit Template插件使用，体验更佳
    - 插件具体使用方法可参考：[《Git Commit Template》](https://www.cnblogs.com/Dyaqi/p/13231260.html)
    - emoji表情可参考[gitmoji](https://gitmoji.carloscuesta.me/)官网及其GitHub仓库示例

#### 反馈交流

- QQ交流群：1045079806
