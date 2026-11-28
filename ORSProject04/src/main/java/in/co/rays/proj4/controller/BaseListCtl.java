
package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.List;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.model.BaseModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseListCtl<B extends BaseBean, M extends BaseModel> extends BaseCtl<B, M> {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        M model = getModel();
        B bean = populateBean(request);

        int pageNo = 1;
        int pageSize = 5;

        List<B> list = model.search(bean, pageNo, pageSize);
        
        System.out.println("LIST FROM DATABASE = " + list);

        ServletUtility.setPageNo(pageNo, request);
        ServletUtility.setPageSize(pageSize, request);
        ServletUtility.setList(list, request);
        
        System.out.println("LIST SET IN REQUEST = " + request.getAttribute("list"));

        ServletUtility.forward(getView(), request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = DataUtility.getString(request.getParameter("operation"));
        int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
        int pageSize = 5;

        BaseBean bean = populateBean(request);
        M model = getModel();

        pageNo = (pageNo == 0) ? 1 : pageNo;

        if (OP_SEARCH.equalsIgnoreCase(op)) {
            pageNo = 1;
        }

        List<B> list = model.search(bean, pageNo, pageSize);

        ServletUtility.setList(list, request);
        ServletUtility.setPageNo(pageNo, request);
        ServletUtility.setPageSize(pageSize, request);

        if (list == null || list.size() == 0) {
            ServletUtility.setErrorMessage("No record found ", request);
        }

        ServletUtility.forward(getView(), request, response);
    }
}
