package org.gly.fmmall.dao;

import org.gly.fmmall.entity.IndexImg;
import org.gly.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {
    public List<IndexImg> listIndexImages();
}