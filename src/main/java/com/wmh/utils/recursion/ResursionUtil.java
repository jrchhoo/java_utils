package com.wmh.utils.recursion;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @program: utils
 * @description: 递归测试
 * @author: Mr.Hou
 * @create: 2021-10-31 00:07
 **/
public class ResursionUtil {

    public static void getSubDeptIdList( ) {
        // 部门及子部门ID列表
        List<Long> deptIdList = new ArrayList<>();
        // 获取子部门ID
        List<Long> subIdList = queryDetpIdList(1L);
        getDeptTreeList(subIdList, deptIdList);
        System.out.println("子id"+ JSON.toJSONString(deptIdList));
    }


    private static void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
        System.out.println("1111111111" + deptIdList);
        for (Long deptId : subIdList) {
            List<Long> list = queryDetpIdList(deptId);
            if (CollectionUtils.isNotEmpty(list)) {
                getDeptTreeList(list, deptIdList);
            }
            deptIdList.add(deptId);
        }
        System.out.println("22222222222" + subIdList);
    }


    public static List<Long> queryDetpIdList(Long parentId) {
        Map<Long, List<Long>> map = new HashedMap();
        map.put(1L, Lists.newArrayList(1001L,1002L,1003L,1004L));
        map.put(2L, Lists.newArrayList(2001L,2002L,2003L,2004L));
        map.put(3L, Lists.newArrayList(3001L,3002L,3003L,3004L));
        map.put(4L, Lists.newArrayList(4001L,4002L,4003L,4004L));
        map.put(1001L, Lists.newArrayList(10011L,10012L,10013L,10014L));
        map.put(1002L, Lists.newArrayList(10021L,10022L,10023L,10024L));
        map.put(10014L, Lists.newArrayList(100141L,100142L,100143L,100144L));
        map.put(2001L, Lists.newArrayList(20011L,20012L,20013L,20014L));
        return map.get(parentId);
    }



    public static List<Long> queryList(List<Long> childrenList, Long l) {
        List<Long> list = queryDetpIdList(l);
        if (CollectionUtils.isNotEmpty(list)) {
            System.out.println("11111111111"+list);
            for (Long temp: list) {
                System.out.println("===" + temp);
                childrenList.add(temp);
                queryList(childrenList, temp);
            }
        }
        System.out.println("222222222222"+childrenList);
        return childrenList;
    }







    public static void main(String[] args) {
        //ResursionUtil.getSubDeptIdList();
        System.out.println(ResursionUtil.queryList(new ArrayList<Long>(), 1L));
    }


}
