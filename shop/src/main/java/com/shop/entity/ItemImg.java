package com.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemImg extends BaseEntity {

    @Id
    @Column(name = "item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repimgYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String originName, String imgName, String imgUrl) {
        this.oriImgName = originName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
