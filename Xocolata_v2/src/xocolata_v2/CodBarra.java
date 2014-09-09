package xocolata_v2;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
/**
 *
 * @author Lòpez
 */
public class CodBarra { 
    
    
    public CodBarra() {
    }
    
    public static void GenerarCodigos(int idPedido)
    {
        
       Connection conexion = ConexionDB.ObtenerConexion();
      try {
          

           try (Statement comando = (Statement)conexion.createStatement()) {
               ResultSet dato = comando.executeQuery("SELECT codigoProducto FROM tblProductos WHERE idPedido = '" + idPedido + "'");
               
               ActiveXComponent oWord = new ActiveXComponent("Word.Application");
               boolean tVisible = true;
               
               oWord.setProperty("Visible", new Variant(tVisible));
               Object oDocuments = oWord.getProperty("Documents").toDispatch();
               
               Dispatch.call((Dispatch)oDocuments, "Add").toDispatch();
               Object oSelection = oWord.getProperty("Selection").toDispatch();
               Object oFind = oWord.call((Dispatch)oSelection, "Find").toDispatch();
               
               Dispatch.call((Dispatch) oSelection, "MoveDown");
               Object oImage = Dispatch.get((Dispatch)oSelection, "InLineShapes").toDispatch();
               
               int contador = 0;
               while(dato.next())
               {
                   contador++;
                   String archivo = System.getProperty("user.home")+"/codigo.jpg";
                   CrearCodigo(dato.getString("codigoProducto"));
                   Dispatch.call((Dispatch) oSelection, "MoveDown");
                   Dispatch.get((Dispatch)oSelection, "InLineShapes").toDispatch();
                   Dispatch.call((Dispatch)oImage, "AddPicture", archivo);
                   Dispatch.put((Dispatch)oSelection, "Text", "   ");
                   //if(contador == 6)
                   {
                       //Dispatch.put((Dispatch)oSelection, "Text", "\r\n");
                       contador = 0;
                   }
               }
           }
            conexion.close();
        } catch (SQLException e){}
    }
    
     public static void CrearCodigo(String codigo) {
    try {
      Code128Bean bean = new Code128Bean();
      final int dpi = 200;
      String ruta = System.getProperty("user.home")+"/codigo.jpg";
      //Configure the barcode generator
      bean.setModuleWidth(UnitConv.in2mm(2.8f / dpi));
      bean.doQuietZone(false);

      //Open output file
      File outputFile = new File(ruta);
      FileOutputStream out = new FileOutputStream(outputFile);
    
      BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false);

      //Generate the barcode
      bean.generateBarcode(canvas, codigo);
   
      //Signal end of generation
      canvas.finish();
    }
    catch (IOException ex) {
    }
  }
    

}
