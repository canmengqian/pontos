package com.pontons.spring.es.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className BookInfo
 * @description TODO
 * @date 2022/1/6
 */
@Data
@Document(indexName = "testdoct")
public class BookInfo {
}
