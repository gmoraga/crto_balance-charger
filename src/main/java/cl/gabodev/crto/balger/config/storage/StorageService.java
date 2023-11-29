//package cl.gabodev.crto.balger.config.storage;
//
//import java.nio.file.Path;
//import java.util.stream.Stream;
//
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
////@Service
////@Component
//public interface StorageService {
//
//	void init();
//
//	void store(MultipartFile file);
//
//	Stream<Path> loadAll();
//
//	Path load(String filename);
//
//	Resource loadAsResource(String filename);
//
//	void deleteAll();
//
//}