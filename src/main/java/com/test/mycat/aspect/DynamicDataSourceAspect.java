package com.test.mycat.aspect;

import com.test.mycat.annotation.TargetDateSource;
import com.test.mycat.config.db.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @Auther: huang
 * @Date: 2019/6/18 14:54
 * @Description:
 */
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDateSource ds) throws Throwable {
        String dsId = ds.value();
        if (DynamicDataSourceContextHolder.dataSourceIds.contains(dsId)) {
            DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
            logger.info("使用数据源 :{} >", dsId, point.getSignature());
        } else {
            logger.info("数据源[{}]不存在，使用默认数据源 >{}", dsId, point.getSignature());
            DynamicDataSourceContextHolder.useMasterDataSource();
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, TargetDateSource ds) {
        logger.info("重置数据源 : " + ds.value() + " > " + point.getSignature());
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();

    }

}