/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import modelo.empresas.Empresa;
import modelo.trabajadores.Trabajador;

/**
 *
 * @author David
 */
public class GestorDatosFicheros implements IService {
    
    private static String directorioApp = "empleadosaplicacion";
    private static String directorioInformes = "informes";
    private static String ficheroEmresas = "FicheroEmpresas.Dat" ;
    private static Path pathDirectorioApp= Path.of("C:\\" + directorioApp +"\\"); 
    private static Path pathDirectorioInformes = Path.of("C:\\" +directorioApp +"\\" + directorioInformes + "\\"); 
    private static Path pathFichero = Path.of("C:\\" + directorioApp+ "\\" + ficheroEmresas);
    
    private static Optional<GestorDatosFicheros> instanciaGestor = Optional.empty();
    
    public GestorDatosFicheros(){
        
    }
    
    public static GestorDatosFicheros inicializaGestorSingleton(){
        try{
            if  (!Files.exists(pathDirectorioApp))
                Files.createDirectories(pathDirectorioApp);
            if (!Files.exists(pathDirectorioInformes))
                Files.createDirectories(pathDirectorioInformes);
            if (!Files.exists(pathFichero))
                Files.createFile(pathFichero);
            if (GestorDatosFicheros.instanciaGestor.isEmpty())
                instanciaGestor = Optional.of(new GestorDatosFicheros());
        }catch (IOException e){
            e.printStackTrace();
        }
        return instanciaGestor.get();
    }
    
    public static void delete(){
        try{
        Files.deleteIfExists(pathFichero);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean write(Map<String, Empresa> empresa) throws IOException {
        
        try{
            Files.write(pathFichero, deListaABytes(empresa.values().stream().collect(Collectors.toList())), StandardOpenOption.CREATE);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public Optional<Map<String, Empresa>> read() {
       Optional<Map<String, Empresa>> optionalResultado = Optional.empty();
       try{
           byte [] bytesFichero = Files.readAllBytes(pathFichero);
           List<Empresa> listaResultado = deBytesALista(bytesFichero);
           optionalResultado = Optional.of(listaResultado.stream().collect(Collectors.toMap( t -> t.getRazonSocial(), e -> e)));
       }catch (Exception e){
           e.printStackTrace();
           return optionalResultado;
       }
       return optionalResultado;
    }
    
    private byte[] deListaABytes(List <Empresa> listEmpresas) throws IOException{
        ByteArrayOutputStream salidaByte = new ByteArrayOutputStream();
        
        ObjectOutputStream salidaObjeto = new ObjectOutputStream(salidaByte);
        salidaObjeto.writeObject(listEmpresas);
        salidaObjeto.flush();
        salidaObjeto.close();
        
        return salidaByte.toByteArray();
    }
    
    private List<Empresa> deBytesALista(byte[] bytes){
        List<Empresa> listaEmpreRecuperada = null;
        ByteArrayInputStream entradaBytes = new ByteArrayInputStream(bytes);
        ObjectInputStream in;
        try{
            in = new ObjectInputStream(entradaBytes);
            listaEmpreRecuperada = (List<Empresa>) in.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return listaEmpreRecuperada;
    }
    
    
}
