package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingAftersale;
import com.walrus.manufacturing.db.domain.ManufacturingAftersaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingAftersaleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int insert(ManufacturingAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    ManufacturingAftersale selectOneByExample(ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    ManufacturingAftersale selectOneByExampleSelective(@Param("example") ManufacturingAftersaleExample example, @Param("selective") ManufacturingAftersale.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    List<ManufacturingAftersale> selectByExampleSelective(@Param("example") ManufacturingAftersaleExample example, @Param("selective") ManufacturingAftersale.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    List<ManufacturingAftersale> selectByExample(ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    ManufacturingAftersale selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingAftersale.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    ManufacturingAftersale selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    ManufacturingAftersale selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingAftersale record, @Param("example") ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingAftersale record, @Param("example") ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingAftersale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingAftersaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_aftersale
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}