# 1、Nacos支持AP和CP的切换，默认为AP模式，如需切换至CP，请执行如下操作。
CMD下执行：curl -X PUT "$NACOS_SERVER:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP"
