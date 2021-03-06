package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingCategory;
import com.walrus.manufacturing.db.domain.ManufacturingCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int insert(ManufacturingCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    ManufacturingCategory selectOneByExample(ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    ManufacturingCategory selectOneByExampleSelective(@Param("example") ManufacturingCategoryExample example, @Param("selective") ManufacturingCategory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    List<ManufacturingCategory> selectByExampleSelective(@Param("example") ManufacturingCategoryExample example, @Param("selective") ManufacturingCategory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    List<ManufacturingCategory> selectByExample(ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    ManufacturingCategory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingCategory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    ManufacturingCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    ManufacturingCategory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingCategory record, @Param("example") ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingCategory record, @Param("example") ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_category
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}