package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.IndexImgMapper;
import org.gly.fmmall.entity.IndexImg;
import org.gly.fmmall.service.IndexImagesService;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexImagesServiceImpl implements IndexImagesService {
    @Autowired
    private IndexImgMapper indexImgMapper;
    @Override
    public ResultVO queryIndexImages() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImages();
        return new ResultVO(ResStatus.OK,"操作成功",indexImgs);
    };

}
