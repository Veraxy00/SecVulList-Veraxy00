# SecVulList-Veraxy00
分享一些我发现的漏洞，涉及细节和利用。

## [Apache Flink远程代码执行漏洞](https://github.com/Veraxy00/SecVulList-Veraxy00/tree/main/Flink-Kafka-Vul)

Apache Flink Web UI 默认没有用户权限认证，攻击者可以直接上传恶意Jar包，通过指定Kafka数据源连接属性，利用Apache Kafka JNDI注入(CVE-2023-25194)漏洞[1]攻击Flink，最终实现远程代码执行。

[1] https://kafka.apache.org/cve-list#CVE-2023-25194
