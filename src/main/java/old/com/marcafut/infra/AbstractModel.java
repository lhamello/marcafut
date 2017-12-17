package old.com.marcafut.infra;

/**
 * Abstract class for system model classes.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <K>
 *            entity primary key type.
 */
//public abstract class AbstractModel<K> implements Serializable {
//
//    private static final long serialVersionUID = 1L;
////    @Inject
////    protected Logger logger;
////    @Inject
//    protected MessageBundleUtil bundle;
//    
//    /**
//     * Returns the entity primary key.
//     * 
//     * @return primary key;
//     */
//    public abstract K getId();
//    
//    @Override
//    @SuppressWarnings("rawtypes")
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        
//        if (obj == null) {
//            return false;
//        }
//        
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        AbstractModel other = (AbstractModel) obj;
//        
//        if (getId() == null) {
//            if (other.getId() != null) {
//                return false;
//            }
//        } else if (!getId().equals(other.getId())) {
//            return false;
//        }
//        
//        return true;
//    }
//    
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        return result;
//    }
//    
//    /**
//     * Builds a {@code String} for the {@code toString()} method through
//     * <i>Java</i> reflection.
//     */
////    @Override
////    @SuppressWarnings("rawtypes")
////    public String toString() {
////        Class clazz = this.getClass();
////        
////        StringBuilder stObjeto = new StringBuilder(500);
////        stObjeto.append(clazz.getName()).append('[');
////        
////        Field[] fields = clazz.getDeclaredFields();
////        
////        for (int i = 0; i < fields.length; i++) {
////            if (i != 0) {
////                stObjeto.append(',');
////            }
////
////            Field field = fields[i];
////            field.setAccessible(true);
////
////            try {
////                stObjeto.append(field.getName()).append('=').append(field.get(this));
////            } catch (IllegalArgumentException | IllegalAccessException ex) {
////                StringBuilder msgWarn = new StringBuilder();
////                
////                msgWarn.append(this.getClass().getSimpleName()).append('[');
////                msgWarn.append("Ocorreu um erro ao acessar o atributo").append(": ").append(field);
////                msgWarn.append(']');
////                
////                logger.warn(msgWarn.toString(), ex);
////            }
////        }
////
////        stObjeto.append(']');
////        return stObjeto.toString();
////    }
//    
//}
