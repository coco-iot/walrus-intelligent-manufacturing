package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingFeedback;
import com.walrus.manufacturing.db.domain.ManufacturingFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingFeedbackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int insert(ManufacturingFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    ManufacturingFeedback selectOneByExample(ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    ManufacturingFeedback selectOneByExampleSelective(@Param("example") ManufacturingFeedbackExample example, @Param("selective") ManufacturingFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    List<ManufacturingFeedback> selectByExampleSelective(@Param("example") ManufacturingFeedbackExample example, @Param("selective") ManufacturingFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    List<ManufacturingFeedback> selectByExample(ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    ManufacturingFeedback selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    ManufacturingFeedback selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    ManufacturingFeedback selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingFeedback record, @Param("example") ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingFeedback record, @Param("example") ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_feedback
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}