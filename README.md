# LogVisualizationELK
using ELK framework to visualize logs for java application

1. [Sample log](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/demoApplication.log) file generated as part of source code

2. Download Logstash, Kibana, Elastic search

3. In logstash, create a file [logstash.conf](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/logstash.conf), which is added to the source code

4. Edit [kibana.yml](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/kibana.yml) under config folder, with the following

5. start logstash with the following
./logstash -f logstash.conf

6.start elastic search

![alt text](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/elastic%20search.png)

7. starts Kibana

![alt text](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/kibana.png)



Reference - https://howtodoinjava.com/microservices/elk-stack-tutorial-example/

