package patterns.structural.facade.facade;

import java.io.File;

import patterns.structural.facade.some_complex_media_library.*;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        // Inside this method, you implement all the logic that manipulate the subsystem. -- leo 
        // Client doesn't need to know about the logic. 
        // All this logic is what allows you to use that library.
        // This facade is not adding any extra behavior.
        // It's just simplifying access to our complex subsystem.

        System.out.println("VideoConversionFacade: conversion started.");
        
        VideoFile file = new VideoFile(fileName);
        
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        
        if (format.equals("mp4")) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }
        
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        
        File result = (new AudioMixer()).fix(intermediateResult);
        
        System.out.println("VideoConversionFacade: conversion completed.");
        
        return result;
    }
}
