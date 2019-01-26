package controllers.lmat.helpers;


import models.Lmat.Articulo;
import models.Lmat.InventarioDisponible;
import play.db.jpa.JPA;
import views.vo.LmatVO;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.*;


public class LmatHelper {


    @Inject
    public LmatHelper() {

    }
    /**
     * Metodo para obtener la lista de lmat
     * @param page pagina en la que se encuentra la lista
     * @param criteria criterio de busqueda
     * @param location tienda en la que se realiza la consulta
     */
    public List<LmatVO> getLmat(long page, String criteria, String location,String quickSearch){
            List<LmatVO> lmatVOList = new ArrayList<>();
            String query ="select * from madres_disponibles where (0=0) ";
        if(null!=criteria && !"NONE".equals(criteria)){
            query=query+" "+criteria;
        }
        if(null!=quickSearch){
            query=query+" "+quickSearch;
        }
           query=query+" limit 12 OFFSET "+((page - 1) * 12);
            List<Object[]> totalCallQueryList = JPA.em().createNativeQuery(query).getResultList();
            for (Object lmatName : totalCallQueryList) {
                Object[] Article=(Object[]) lmatName;
                LmatVO lmatVO = new LmatVO();
                lmatVO.setCode((String) Article[0]);
                lmatVO.setName((String)Article[9]);
                lmatVO.setImgRoute("temporaryImageRoute");
                InventarioDisponible inventarioDisponible=getLmatLatestInv((String) Article[0],location);
                if(null!=inventarioDisponible){
                lmatVO.setTotalAviable(Double.parseDouble(inventarioDisponible.getFisica_disponible()));
                }else{
                    lmatVO.setTotalAviable(0.0);
                }
                lmatVOList.add(lmatVO);
            }
            return lmatVOList;
    }

    /**
     * Metodo para obtener los datos de un lmat especifico
     * @param location
     * @param lmatCode
     * @return
     */
    public String getLmatData( String location,String lmatCode){
        return null;
    }

    /**
     * Metodo encargado de traer la suma de los movimientos de una articulo despues de su ultimo inventario
     * @param articleCod
     * @return
     */
    public Object findTransactionsAfterInv(String articleCod, String invDate) {
            try {
            String query = "select sum(cast(ti.cantidad as float )) from transacciones_inventario ti where ti.codigo_articulo=\'"+articleCod+"\' and ti.fecha_financiera >= \'"+invDate+"\'";
            Object result=JPA.em().createNativeQuery(query).getSingleResult();
                return result;
            } catch (NoResultException nre) {
                return 0L;
            }
    }

    /**
     * Metodo para las paginas de las listas de lmat
     * @param criteria
     * @param location
     * @param actualPage
     * @return
     */
    public Long getLmatPages(String criteria, String location,Long actualPage,String quickSearch){
        String query = "select count(*) from madres_disponibles where (0=0)";
        if(null!=criteria && !"NONE".equals(criteria)){
            query=query+" "+criteria;
        }
        if(null!=quickSearch){
            query=query+" "+quickSearch;
        }
        BigInteger totalCallQueryList = (BigInteger) JPA.em().createNativeQuery(query).getSingleResult();
        long totalpages = (long) Math.ceil(totalCallQueryList.doubleValue() / 12);
        return totalpages;
    }
    /**
     * Metodo para encontrar un articulo que corresponde a una lmat
     * @param articleCode
     * @return
     */
    private Articulo getArticleByLmat(String articleCode){
            Query query = JPA.em().createNamedQuery("Articulo.findByCode").setParameter("articleCode", articleCode);
            try {
                return  (Articulo) query.getSingleResult();
            } catch (NoResultException nre) {
                //Logger.error("La lmat no tiene articulo en la base de datos " + nre);
                return null;
            }
    }
    /**
     * Metodo para obltener el ultimo inventario de una lmap
     * @param lmatCocde
     * @return
     */
    private InventarioDisponible getLmatLatestInv(String lmatCocde, String store){
        Query query = JPA.em().createNamedQuery("InventarioDisponible.findReferenceInLatesInv").setParameter("articleCode", lmatCocde).setParameter("tienda",store);
        try {
            return  (InventarioDisponible) query.getSingleResult();
        } catch (NoResultException nre) {
            //Logger.error("Inventario no existe en la base de datos" + lmatCocde + " " + nre);
            return null;
        }
    }

    /**
     * Metodo obtener las paginas viables para observacion
     * @param totalPages
     * @param actualPage
     * @return
     */
    public List<Long> getAviablePages(Long totalPages,Long actualPage){
        List<Long> visiblePages=new ArrayList<>();
        if(actualPage-2>0){
            visiblePages.add(actualPage-2);
        }
        if(actualPage-1>0){
            visiblePages.add(actualPage-1);
        }
        visiblePages.add(actualPage);
        if(actualPage+1<=totalPages){
            visiblePages.add(actualPage+1);
        }
        if(actualPage+2<=totalPages){
            visiblePages.add(actualPage+2);
        }
        return visiblePages;
    }
}
