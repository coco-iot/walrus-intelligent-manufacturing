package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingSearchHistory;
import com.walrus.manufacturing.db.domain.ManufacturingSearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingSearchHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int insert(ManufacturingSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    ManufacturingSearchHistory selectOneByExample(ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    ManufacturingSearchHistory selectOneByExampleSelective(@Param("example") ManufacturingSearchHistoryExample example, @Param("selective") ManufacturingSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    List<ManufacturingSearchHistory> selectByExampleSelective(@Param("example") ManufacturingSearchHistoryExample example, @Param("selective") ManufacturingSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    List<ManufacturingSearchHistory> selectByExample(ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    ManufacturingSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    ManufacturingSearchHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    ManufacturingSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingSearchHistory record, @Param("example") ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingSearchHistory record, @Param("example") ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}