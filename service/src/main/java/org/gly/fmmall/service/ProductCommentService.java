package org.gly.fmmall.service;

import org.gly.fmmall.vo.ResultVO;

public interface ProductCommentService {
    public ResultVO getProductComments(String pid, int Count, int pageCount);

    public ResultVO getProductCommentsCount(String pid);
}
