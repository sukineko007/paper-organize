package edu.nwafu.paper.service;

import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;

import java.util.List;

public interface ItemService {

    List getItems(Integer page, Integer limit);

    void insert(BaseRequest request);

    void delete(Integer id);

    void batchDelete(String ids);

    void update(UpdateRequest request);
}
