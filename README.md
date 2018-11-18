# LogVisualizationELK
using ELK framework to visualize logs for java application

1. Download Logstash, Kibana, Elastic search
2. In logstash, create a file logstash.conf and add the following

input {
  file {
    type => "java"
    path => "/Users/vishakhrameshan/Documents/Workspace/Logging_examples/logsToElk/demoApplication.log"
    codec => multiline {
      pattern => "^%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME}.*"
      negate => "true"
      what => "previous"
    }
  }
}
 
filter {
  //If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
  if [message] =~ "\tat" {
    grok {
      match => ["message", "^(\tat)"]
      add_tag => ["stacktrace"]
    }
  }
 
 grok {
    match => [ "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- \[(?<thread>[A-Za-z0-9-]+)\] [A-Za-z0-9.]*\.(?<class>[A-Za-z0-9#_]+)\s*:\s+(?<logmessage>.*)",
               "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- .+? :\s+(?<logmessage>.*)"
             ]
  }
 
  
  date {
    match => [ "timestamp" , "yyyy-MM-dd HH:mm:ss.SSS" ]
  }
}
 
output {
   
  stdout {
    codec => rubydebug
  }
 
  //Sending properly parsed log events to elasticsearch
  elasticsearch { 
     hosts => ["localhost:9200"] 
     index => "YOUR_INDEX_NAME-%{+YYYY.MM.dd}"
  }
}

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

