/*
 * Sonar 1С Plugin
 * Copyright (C) 2017 Vasiliy Kazmin and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins._1C.core;

import org.sonar.api.batch.AbstractSourceImporter;
import org.sonar.api.batch.Phase;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.InputFileUtils;
import org.sonar.api.resources.ProjectFileSystem;

@Phase(name = Phase.Name.PRE)
public class _1CSourceImporter extends AbstractSourceImporter {

  public _1CSourceImporter(_1C _1c) {
    super(_1c);
  }

  protected void analyse(ProjectFileSystem fileSystem, SensorContext context) {
    parseDirs(context, InputFileUtils.toFiles(fileSystem.mainFiles(_1C.KEY)), fileSystem.getSourceDirs(), false, fileSystem.getSourceCharset());
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
