# LogVisualizationELK
using ELK framework to visualize logs for java application

1. Download Logstash, Kibana, Elastic search

2. In logstash, create a file logstash.conf, which is added to the source code

3. Edit kibana.yml under config folder, with the following
//The URL of the Elasticsearch instance to use for all your queries.
elasticsearch.url: "http://localhost:9200"

4. start logstash with the following
./logstash -f logstash.conf

5. start elastic search

![alt text](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/elastic%20search.png)

6. starts Kibana

![alt text](https://github.com/Hitman007IN/LogVisualizationELK/blob/master/kibana.png)



Reference - https://howtodoinjava.com/microservices/elk-stack-tutorial-example/

