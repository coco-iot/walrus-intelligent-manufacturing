package com.walrus.manufacturing.db.dao;

import com.walrus.manufacturing.db.domain.ManufacturingNoticeAdmin;
import com.walrus.manufacturing.db.domain.ManufacturingNoticeAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturingNoticeAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    long countByExample(ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int deleteByExample(ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int insert(ManufacturingNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int insertSelective(ManufacturingNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    ManufacturingNoticeAdmin selectOneByExample(ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    ManufacturingNoticeAdmin selectOneByExampleSelective(@Param("example") ManufacturingNoticeAdminExample example, @Param("selective") ManufacturingNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    List<ManufacturingNoticeAdmin> selectByExampleSelective(@Param("example") ManufacturingNoticeAdminExample example, @Param("selective") ManufacturingNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    List<ManufacturingNoticeAdmin> selectByExample(ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    ManufacturingNoticeAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ManufacturingNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    ManufacturingNoticeAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    ManufacturingNoticeAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ManufacturingNoticeAdmin record, @Param("example") ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ManufacturingNoticeAdmin record, @Param("example") ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ManufacturingNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ManufacturingNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ManufacturingNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacturing_notice_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}