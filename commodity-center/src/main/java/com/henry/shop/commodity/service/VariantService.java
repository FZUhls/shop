package com.henry.shop.commodity.service;

import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.VariantException;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品规格接口
 * <h1>主要包括商品规格组的增删查改和规格的增删查改</h1>
 * <ul>
 * <li>规格组的增加 {@link #createVariantGroup(VariantGroupDto)}</li>
 * <li>规格组的删除 {@link #deleteVariantGroup(long)}</li>
 * <li>规格组的修改 {@link #updateVariantGroup(long, VariantGroupDto)}</li>
 * <li>规格组按id查询 {@link #getVariantGroupById(long)}</li>
 * <li>按规格组id获取组内规格 {@link #getVariantsByGroupId(long)}</li>
 * <li>规格按规格组id查询{@link #getVariantByGroupId(long)}</li>
 * <li>规格的增加 {@link #createVariant(VariantDto)}</li>
 * <li>规格的删除 {@link #deleteVariant(long)}</li>
 * <li>规格的修改 {@link #updateVariant(long, VariantDto)}</li>
 * <li>规格的查询 {@link #getVariantGroupById(long)}</li>
 * </ul>
 *
 * @author Henry
 * @version 1.0
 * @since 2021/11/9
 */
public interface VariantService {

    /**
     * 根据id获取规格组
     *
     * @param groupId 规格组id
     * @return ComVariantGroup规格组
     * @throws DataNotFoundException 查询不到时抛出异常
     */
    ComVariantGroup getVariantGroupById(long groupId) throws DataNotFoundException;

    /**
     * 按规格组id查询组内规格
     * @param groupId 规格组id
     * @return 规格列表
     */
    List<ComVariant> getVariantsByGroupId(long groupId);

    /**
     * 根据id获取规格
     *
     * @param id 规格id
     * @return ComVariantGroup
     * @throws DataNotFoundException 查询不到时抛出异常
     */
    ComVariant getVariantById(long id) throws DataNotFoundException;

    /**
     * 添加规格组
     *
     * @param variantGroupDto 规格组dto
     * @return 创建成功的结果
     */
    @Transactional(rollbackFor = Exception.class)
    ComVariantGroup createVariantGroup(VariantGroupDto variantGroupDto);

    /**
     * @param variantDto 规格组
     * @return 创建成功的结果
     */
    @Transactional(rollbackFor = Exception.class)
    ComVariant createVariant(VariantDto variantDto) throws DataNotFoundException, VariantException;

    /**
     * @param id              规格组id
     * @param variantGroupDto 规格组dto
     * @return 修改后的规格组
     * @throws DataNotFoundException 不存在指定id的规格组时抛出异常
     */
    @Transactional(rollbackFor = Exception.class)
    ComVariantGroup updateVariantGroup(long id, VariantGroupDto variantGroupDto) throws DataNotFoundException;

    /**
     * @param id         规格id
     * @param variantDto 规格dto
     * @return 修改后的规格
     * @throws DataNotFoundException 不存在指定id的规格组时抛出异常
     */
    @Transactional(rollbackFor = Exception.class)
    ComVariant updateVariant(long id, VariantDto variantDto) throws DataNotFoundException;

    /**
     * @param id 规格组id
     * @throws DataNotFoundException 不存在指定id的规格组时抛出异常
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteVariantGroup(long id) throws DataNotFoundException;

    /**
     * @param id 规格组id
     * @throws DataNotFoundException 不存在指定id的规格组时抛出异常
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteVariant(long id) throws DataNotFoundException;

    /**
     * @param groupId 规格组id
     * @return 规格列表
     */
    List<ComVariant> getVariantByGroupId(long groupId);
}
