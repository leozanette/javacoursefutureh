package com.betrybe.model;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

/**
 * classe para buscar arquivo do formdata da requisicao.
 *
 */
public class FormData {

  @RestForm("file")
  private FileUpload file;

  public FileUpload getFile() {
    return file;
  }
}
