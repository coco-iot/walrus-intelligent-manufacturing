package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingIssue;
import com.walrus.manufacturing.db.domain.ManufacturingIssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingIssueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int insert(ManufacturingIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    ManufacturingIssue selectOneByExample(ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    ManufacturingIssue selectOneByExampleSelective(@Param("example") ManufacturingIssueExample example, @Param("selective") ManufacturingIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    List<ManufacturingIssue> selectByExampleSelective(@Param("example") ManufacturingIssueExample example, @Param("selective") ManufacturingIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    List<ManufacturingIssue> selectByExample(ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    ManufacturingIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    ManufacturingIssue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    ManufacturingIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingIssue record, @Param("example") ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingIssue record, @Param("example") ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}