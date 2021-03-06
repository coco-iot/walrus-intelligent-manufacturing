package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingGroupon;
import com.walrus.manufacturing.db.domain.ManufacturingGrouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingGrouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int insert(ManufacturingGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    ManufacturingGroupon selectOneByExample(ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    ManufacturingGroupon selectOneByExampleSelective(@Param("example") ManufacturingGrouponExample example, @Param("selective") ManufacturingGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    List<ManufacturingGroupon> selectByExampleSelective(@Param("example") ManufacturingGrouponExample example, @Param("selective") ManufacturingGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    List<ManufacturingGroupon> selectByExample(ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    ManufacturingGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    ManufacturingGroupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    ManufacturingGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingGroupon record, @Param("example") ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingGroupon record, @Param("example") ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}