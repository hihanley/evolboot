-- 公告
DROP TABLE IF EXISTS evol_content_notice;
CREATE TABLE evol_content_notice
(
    id_               bigint   NOT NULL COMMENT '主键',
    create_time_      datetime NOT NULL COMMENT '创建时间',
    last_modify_time_ datetime NOT NULL COMMENT '最后修改时间',
    version_          bigint   NOT NULL DEFAULT 0 COMMENT '乐观锁的版本号',

    sort_             int COMMENT '排序',
    enable_           tinyint(1)        default 1 COMMENT '是否显示',
    released_time_    datetime COMMENT '发布时间',
    locales_          text COMMENT '多语言',
    PRIMARY KEY (id_)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='公告';
