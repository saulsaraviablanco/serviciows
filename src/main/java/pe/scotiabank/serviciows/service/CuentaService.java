package pe.scotiabank.serviciows.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.CuentaDTO;
import pe.scotiabank.serviciows.model.CuentaModel;
import pe.scotiabank.serviciows.repository.CuentaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    private final ModelMapper modelMapper;
    private final CuentaRepository cuentaRepository;

    public CuentaService(ModelMapper modelMapper, CuentaRepository cuentaRepository) {
        this.modelMapper = modelMapper;
        this.cuentaRepository = cuentaRepository;
    }

    public List<CuentaDTO> getAllCuentas() {
        List<CuentaModel> cuentas = cuentaRepository.findAll();
        List<CuentaDTO> cuentaDTOS = cuentas.stream()
            .map(cuenta -> modelMapper.map(cuenta, CuentaDTO.class))
            .toList();
        return cuentaDTOS;
    }

    public CuentaDTO getCuentaById(Integer id){
        Optional<CuentaModel> cuentaModel = cuentaRepository.findById(id);
        if(cuentaModel.isEmpty()){
            return new CuentaDTO();
        }
        return modelMapper.map(cuentaModel, CuentaDTO.class);
    }

    public CuentaDTO addCuenta(CuentaDTO cuentaDTO) {
        CuentaModel cuentaModel = modelMapper.map(cuentaDTO, CuentaModel.class);
        cuentaModel = cuentaRepository.save(cuentaModel);
        return modelMapper.map(cuentaModel, CuentaDTO.class);
    }

    public boolean deleteCuenta(Integer id) {
        if (cuentaRepository.existsById(id)) {
            cuentaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
