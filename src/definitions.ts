export interface CapacitorAppInstallerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
