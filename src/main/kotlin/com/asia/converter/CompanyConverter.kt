package com.asia.converter

import com.asia.models.bo.CompanyBO
import com.asia.models.query.CompanyQuery
import com.asia.models.vo.CompanyVO
import com.asia.repository.entity.CompanyEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface CompanyConverter {
    @Mapping(source = "phone", target = "tel")
    fun convertToBO(companyQuery: CompanyQuery): CompanyBO

    //Parameter specified as non-null is null: method com.asia.repository.entity.CompanyEntity.<init>, parameter id
    // @InheritInverseConfiguration
    // fun convertToEntity(companyBO: CompanyBO): CompanyEntity

    fun covertToVO(companyEntity: CompanyEntity): CompanyVO
}