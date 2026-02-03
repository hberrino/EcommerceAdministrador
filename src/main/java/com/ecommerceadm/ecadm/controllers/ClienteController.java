@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        return ResponseEntity.ok(
            clienteService.ListarClientes()
        );
    }

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
            clienteService.obtenerClientePorID(id)
        );
    }

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorEmail(
            @PathVariable String email) {

        return ResponseEntity.ok(
            clienteService.obtenerClientePorEmail(email)
        );
    }

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dni/{dni}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorDNI(
            @PathVariable String dni) {

        return ResponseEntity.ok(
            clienteService.obtenerClientePorDNI(dni)
        );
    }

    // 🌍 PÚBLICO (registro de cliente)
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crearCliente(
            @RequestBody @Valid ClienteCreateDTO clienteCreate) {

        ClienteResponseDTO creado =
                clienteService.crearCliente(clienteCreate);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }

    // 🔒 ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(
            @PathVariable Long id) {

        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    // 🔒 ADMIN (más adelante USER propio)
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizarCliente(
            @PathVariable Long id,
            @RequestBody ClienteUpdateDTO clienteUpdate) {

        return ResponseEntity.ok(
            clienteService.actualizarCliente(id, clienteUpdate)
        );
    }
}
