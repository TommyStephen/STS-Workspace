package com.tutorial.imageUpload.response;

import com.tutorial.imageUpload.model.ImageUpload;

public class ResponseMapper {

	public static ImageUploadResponse entityToResponseMapper(ImageUpload ImageUploadEntity) {
		ImageUploadResponse response = new ImageUploadResponse();
		response.setId(ImageUploadEntity.getId());
		response.setName(ImageUploadEntity.getName());
		response.setDescription(ImageUploadEntity.getDescription());
		response.setPrice(ImageUploadEntity.getPrice());
		response.setImagePath(ImageUploadEntity.getImagePath());
		response.setImageFullPath(ImageUploadEntity.getImageFullPath());
		response.setImageContentType(ImageUploadEntity.getImageContentType());
		return response;
	}
}
