/**
 * Options for installing an application.
 */
export interface AppInstallOptions {
  /**
   * The path to the file to be installed.
   */
  file: string;
}

/**
 * The Capacitor App Installer Plugin.
 */
export interface CapacitorAppInstallerPlugin {
  /**
   * Installs an application with the given options.
   * 
   * @param options - The options for the app installation.
   * @returns A promise that resolves when the installation is complete.
   */
  install(options: AppInstallOptions): Promise<void>;
}
