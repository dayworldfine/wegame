package com.wegame.provider;

import com.wegame.model.GamblingDetails;
import com.wegame.model.GamblingDetailsExample.Criteria;
import com.wegame.model.GamblingDetailsExample.Criterion;
import com.wegame.model.GamblingDetailsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class GamblingDetailsSqlProvider {

    public String countByExample(GamblingDetailsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_gambling_details");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(GamblingDetailsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_gambling_details");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(GamblingDetails record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_details");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.VALUES("CREATEDATE", "#{createdate,jdbcType=VARCHAR}");
        }
        
        if (record.getLastmodifiedtime() != null) {
            sql.VALUES("LASTMODIFIEDTIME", "#{lastmodifiedtime,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getCompareuser() != null) {
            sql.VALUES("COMPAREUSER", "#{compareuser,jdbcType=VARCHAR}");
        }
        
        if (record.getDotype() != null) {
            sql.VALUES("DOTYPE", "#{dotype,jdbcType=INTEGER}");
        }
        
        if (record.getOperatingleverage() != null) {
            sql.VALUES("OPERATINGLEVERAGE", "#{operatingleverage,jdbcType=INTEGER}");
        }
        
        if (record.getRound() != null) {
            sql.VALUES("ROUND", "#{round,jdbcType=INTEGER}");
        }
        
        if (record.getSeatserial() != null) {
            sql.VALUES("SEATSERIAL", "#{seatserial,jdbcType=INTEGER}");
        }
        
        if (record.getUsercode() != null) {
            sql.VALUES("USERCODE", "#{usercode,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(GamblingDetailsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("CREATEDATE");
        sql.SELECT("LASTMODIFIEDTIME");
        sql.SELECT("VERSION");
        sql.SELECT("COMPAREUSER");
        sql.SELECT("DOTYPE");
        sql.SELECT("OPERATINGLEVERAGE");
        sql.SELECT("ROUND");
        sql.SELECT("SEATSERIAL");
        sql.SELECT("USERCODE");
        sql.FROM("t_gambling_details");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        GamblingDetails record = (GamblingDetails) parameter.get("record");
        GamblingDetailsExample example = (GamblingDetailsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_gambling_details");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.SET("CREATEDATE = #{record.createdate,jdbcType=VARCHAR}");
        }
        
        if (record.getLastmodifiedtime() != null) {
            sql.SET("LASTMODIFIEDTIME = #{record.lastmodifiedtime,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("VERSION = #{record.version,jdbcType=BIGINT}");
        }
        
        if (record.getCompareuser() != null) {
            sql.SET("COMPAREUSER = #{record.compareuser,jdbcType=VARCHAR}");
        }
        
        if (record.getDotype() != null) {
            sql.SET("DOTYPE = #{record.dotype,jdbcType=INTEGER}");
        }
        
        if (record.getOperatingleverage() != null) {
            sql.SET("OPERATINGLEVERAGE = #{record.operatingleverage,jdbcType=INTEGER}");
        }
        
        if (record.getRound() != null) {
            sql.SET("ROUND = #{record.round,jdbcType=INTEGER}");
        }
        
        if (record.getSeatserial() != null) {
            sql.SET("SEATSERIAL = #{record.seatserial,jdbcType=INTEGER}");
        }
        
        if (record.getUsercode() != null) {
            sql.SET("USERCODE = #{record.usercode,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_gambling_details");
        
        sql.SET("ID = #{record.id,jdbcType=VARCHAR}");
        sql.SET("CREATEDATE = #{record.createdate,jdbcType=VARCHAR}");
        sql.SET("LASTMODIFIEDTIME = #{record.lastmodifiedtime,jdbcType=VARCHAR}");
        sql.SET("VERSION = #{record.version,jdbcType=BIGINT}");
        sql.SET("COMPAREUSER = #{record.compareuser,jdbcType=VARCHAR}");
        sql.SET("DOTYPE = #{record.dotype,jdbcType=INTEGER}");
        sql.SET("OPERATINGLEVERAGE = #{record.operatingleverage,jdbcType=INTEGER}");
        sql.SET("ROUND = #{record.round,jdbcType=INTEGER}");
        sql.SET("SEATSERIAL = #{record.seatserial,jdbcType=INTEGER}");
        sql.SET("USERCODE = #{record.usercode,jdbcType=INTEGER}");
        
        GamblingDetailsExample example = (GamblingDetailsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, GamblingDetailsExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}