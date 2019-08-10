package com.xxfy.informatizationlyt.common.repository;

/**
 * 公共数据访问组件（仓库）
 * @param <T>
 */
public interface BaseRepository<T> {
    /**
     * 通过id获取单个实例对象
     */
    T findAllById(Long id);
}
