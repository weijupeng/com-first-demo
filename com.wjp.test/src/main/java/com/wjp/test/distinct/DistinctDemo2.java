package com.wjp.test.distinct;

import com.wjp.common.untils.DateUtils;
import org.apache.commons.codec.binary.StringUtils;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * @author wjp
 * @date 2020/4/8 16:37
 */
public class DistinctDemo2 {
    public static void main(String[] args) {

        {
            //1.数据库查询失败数据
            List<PromotionOriginalInfo> list = getErrorList();
            //根据手机号和产品拿到最新的失败数据
            list.sort(comparing(PromotionOriginalInfo::getCreateTime).reversed());
            list = removeDuplicateOutputField(list);
            for (PromotionOriginalInfo info : list) {
                System.out.println("info = " + info);
            }

        }
    }

    private static List<PromotionOriginalInfo> getErrorList() {
        ArrayList<PromotionOriginalInfo> list = new ArrayList<>();
        list.add(PromotionOriginalInfo.builder().mobile("1234").productCode("123").createTime(
                DateUtils.stringToDate("2020-03-01 00:00:00", DateUtils.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)).promoteSource(1).build());
        list.add(PromotionOriginalInfo.builder().mobile("1234").productCode("123").createTime(
                DateUtils.stringToDate("2020-03-02 00:00:00", DateUtils.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)).promoteSource(2).build());
        list.add(PromotionOriginalInfo.builder().mobile("12344").productCode("12").createTime(
                DateUtils.stringToDate("2020-03-03 00:00:00", DateUtils.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)).promoteSource(3).build());
        list.add(PromotionOriginalInfo.builder().mobile("12344").productCode("12").createTime(
                DateUtils.stringToDate("2020-03-04 00:00:00", DateUtils.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)).promoteSource(4).build());
        list.add(PromotionOriginalInfo.builder().mobile("12345").productCode("12").createTime(
                DateUtils.stringToDate("2020-03-05 00:00:00", DateUtils.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)).promoteSource(5).build());


        return list;
    }

    /**
     * 根据list中对象某些字段去重
     * @param list 需要去重的list
     * @return 返回去重后的list
     */
    private static List<PromotionOriginalInfo> removeDuplicateOutputField(List<PromotionOriginalInfo> list) {
        Set<PromotionOriginalInfo> set = new TreeSet<>((o1, o2) -> {
            int compareToResult = 1;
            //根据需求添加StringUtils.equals(o1.getProductCode(), o2.getProductCode()) ；
            if (StringUtils.equals(o1.getMobile(), o2.getMobile()) &&
                    Objects.equals(o1.getPromoteSource(), o2.getPromoteSource()) &&
                    StringUtils.equals(o1.getProductCode(), o2.getProductCode())) {
                compareToResult = 0;
            }
            return compareToResult;
        });
        set.addAll(list);
        return new ArrayList<>(set);
    }

}
